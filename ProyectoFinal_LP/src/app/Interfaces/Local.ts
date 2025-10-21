// Interface principal para GET
export interface Local {
  id?: number;
  nombre?: string;
  direccion?: string;
  ciudad?: string;
  telefono?: string;
  email?: string;
  capacidad?: number;
  horarioApertura?: string; // formato HH:mm
  horarioCierre?: string; // formato HH:mm
  activo?: boolean;
  createdAt?: Date; // formato ISO DateTime
  updatedAt?: Date; // formato ISO DateTime
}

// Interface para POST (sin id)
export interface LocalPost {
  nombre: string;
  direccion: string;
  ciudad: string;
  telefono: string;
  email: string;
  capacidad: number;
  horarioApertura: string; // formato HH:mm
  horarioCierre: string; // formato HH:mm
  activo: boolean;
}

// Interface para PUT (requiere id)
export interface LocalPut {
  id: number;
  nombre: string;
  direccion: string;
  ciudad: string;
  telefono: string;
  email: string;
  capacidad: number;
  horarioApertura: string; // formato HH:mm
  horarioCierre: string; // formato HH:mm
  activo: boolean;
}
