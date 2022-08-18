import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subject } from 'rxjs';
import * as jwt_decode from "jwt-decode";
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly baseURL =
    'http://localhost:8090/';

  constructor(private httpClient: HttpClient) {}
  private _refreshNeededEtat =new Subject<void>();
  get refreshNeededEtat() {
    return this._refreshNeededEtat;
  }
  loginInApi(rq:any): Observable<any[]> {
    return this.httpClient.post<any>(this.baseURL+"authenticate",rq,{});
  }
  registerFroApi(rq:any):Observable<any> {


    return this.httpClient.post<any>(`${this.baseURL+"singin"}`,rq)
    .pipe(
       map(
         userData =>{
         this. loginInF(userData)
         this._refreshNeededEtat.next()
               return userData;
         }
       )
     );

   }
authenticate(connx:any):Observable<any> {


  return this.httpClient.post<any>(`${this.baseURL+"authenticate"}`,connx)
  .pipe(
     map(
       userData =>{
       this. loginInF(userData)
       this._refreshNeededEtat.next()
             return userData;
       }
     )
   );

 }
  loginInF(userData:any)
  {
    console.log(userData);
    localStorage.setItem("connected","ok")
    localStorage.setItem("idUSer",userData.id)
  }

  loginOut()
  {
    localStorage.removeItem("idUSer")
    localStorage.removeItem("connected")
    this._refreshNeededEtat.next()
  }
  getidU()
  {
    return localStorage.getItem("idUSer")
    
  }
}


