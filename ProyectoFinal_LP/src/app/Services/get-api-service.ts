import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../Environments/environments';
import { Local } from '../Interfaces/Local';
import { Evento } from '../Interfaces/Evento';

@Injectable({
  providedIn: 'root'
})
export class GetApiService {
  protected http = inject(HttpClient);
  protected readonly apiUrl = environment.apiUrl;

  GetLocales(){
    const url = `${this.apiUrl}locales`;
    return this.http.get<Local[]>(url);
  }

  GetEventos(){
    const url = `${this.apiUrl}eventos`;
    return this.http.get<Evento[]>(url);
  }


}
