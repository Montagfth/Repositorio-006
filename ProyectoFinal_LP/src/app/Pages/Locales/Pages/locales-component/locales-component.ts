import { ChangeDetectionStrategy, Component, signal, computed, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GetApiService } from '../../../../Services/get-api-service';
import { Local } from '../../../../Interfaces/Local';

@Component({
  selector: 'app-locales-component',
  imports: [CommonModule],
  templateUrl: './locales-component.html',
  styleUrl: './locales-component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
  standalone: true
})
export class LocalesComponent implements OnInit {

  // Estado del componente
  isLoaded = signal<boolean>(false);
  filtroZona = signal<string>('todos');
  localSeleccionado = signal<Local | null>(null);
  private getApiService = inject(GetApiService);

  // Array de imágenes para usar de forma cíclica
  private imagenesLocales = [
    "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1555396273-367ea4eb4db5?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1590846406792-0adc7f938f1d?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1571997478779-2adcbbe9ab2f?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1552566626-52f8b828add9?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80",
    "https://images.unsplash.com/photo-1559329007-40df8a9345d8?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"
  ];

  // Data de locales
  locales = signal<Local[]>([]);

  // Computed properties
  localesDestacados = computed(() =>
    this.locales().slice(0, 3) // Primeros 3 como destacados
  );

  localesPorZona = computed(() => {
    const filtro = this.filtroZona();
    if (filtro === 'todos') {
      return this.locales();
    }
    // Filtrar por ciudad
    return this.locales().filter(local => local.ciudad?.toLowerCase() === filtro.toLowerCase());
  });

  totalLocales = computed(() => this.locales().length);

  zonasDisponibles = computed(() => {
    const ciudades = [...new Set(this.locales().map(local => local.ciudad).filter(Boolean))];
    return ciudades.map(ciudad => ({
      value: ciudad!.toLowerCase(),
      label: ciudad!,
      count: this.locales().filter(l => l.ciudad?.toLowerCase() === ciudad!.toLowerCase()).length
    }));
  });

  ngOnInit() {
    // Cargar locales desde el backend
    this.cargarLocales();

    // Simular carga de datos
    setTimeout(() => {
      this.isLoaded.set(true);
    }, 100);
  }

  // Método para cargar locales desde el backend
  private cargarLocales(): void {
    this.getApiService.GetLocales().subscribe({
      next: (locales) => {
        this.locales.set(locales);
      },
      error: (error) => {
        console.error('Error al cargar locales:', error);
      }
    });
  }

  // Métodos para filtros
  setFiltroZona(zona: string) {
    this.filtroZona.set(zona);
  }

  getNombreZona(zona: string): string {
    return zona; // Retorna la ciudad tal cual viene del backend
  }

  // Método para obtener imagen de un local (ciclo de imágenes)
  getImagenLocal(index: number): string {
    return this.imagenesLocales[index % this.imagenesLocales.length];
  }

  // Método para formatear horario
  formatearHorario(apertura?: string, cierre?: string): string {
    if (!apertura || !cierre) return 'Horario no disponible';
    return `${apertura} - ${cierre}`;
  }

  // Método para verificar si el local está activo
  isLocalActivo(local: Local): boolean {
    return local.activo ?? false;
  }

  // Métodos para modal
  seleccionarLocal(local: Local) {
    this.localSeleccionado.set(local);
  }

  cerrarModal() {
    this.localSeleccionado.set(null);
  }

  // Métodos de contacto
  llamarLocal(telefono: string) {
    window.open(`tel:${telefono}`, '_self');
  }

  enviarEmail(email: string, nombreLocal: string) {
    const asunto = encodeURIComponent(`Consulta sobre ${nombreLocal}`);
    const cuerpo = encodeURIComponent(`¡Hola!\n\nMe gustaría recibir más información sobre su local.\n\nGracias.`);
    window.open(`mailto:${email}?subject=${asunto}&body=${cuerpo}`, '_self');
  }
}
