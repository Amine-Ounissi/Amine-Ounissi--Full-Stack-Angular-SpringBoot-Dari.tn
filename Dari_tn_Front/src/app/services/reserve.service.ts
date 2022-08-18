import { Injectable, ɵAPP_ID_RANDOM_PROVIDER } from '@angular/core';
//import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reserve } from '../reserve/reserve';
import { Announcement } from '../announcement';

@Injectable({
  providedIn: 'root'
})
export class ReserveService {
  readonly baseURL =
  'http://localhost:8090/DariTn/reservecontroller/Reserves';
  constructor(private httpClient: HttpClient) {}

  getReserveList(): Observable<Reserve[]> {
    return this.httpClient.get<Reserve[]>(this.baseURL);
  }
  
  addReserve(
    reserve: Reserve,
    idan: number,
    idU: number
            ): Observable<Object> {
    return this.httpClient.post<Reserve[]>(`${this.baseURL}/addReserve/${idan}/${idU}`, reserve);
  }
    
  getReserveById(id: number): Observable<Reserve> {
    return this.httpClient.get<Reserve>(`${this.baseURL}/${id}`);
  }
  updateReserve(
    idU: number,
    reserve: Reserve
  ): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${idU}`, reserve);
  }
 
  deleteReserve(id: number): Observable<object> {
    return this.httpClient.delete<Reserve>(`${this.baseURL}/${id}`);
  }

}
