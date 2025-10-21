// Interface principal para GET
export interface Evento {
  id?: number;
  titulo?: string;
  descripcion?: string;
  fechaInicio?: string;
  fechaFin?: string;
  aforoMaximo?: number;
  estado?: string;
  localId?: number;
  createdAt?: string;
  updatedAt?: string;

}

// Interface para POST (sin id)
export interface EventoPost {
  titulo: string;
  descripcion: string;
  fechaInicio: string;
  fechaFin: string;
  aforoMaximo: number;
  estado: string;
  localId: number;
}

// Interface para PUT (requiere id)
export interface EventoPut {
  id: number;
  titulo: string;
  descripcion: string;
  fechaInicio: string;
  fechaFin: string;
  aforoMaximo: number;
  estado: string;
  localId: number;
}
