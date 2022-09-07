import { Injectable } from '@angular/core';
//import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from './announcement';
@Injectable({
  providedIn: 'root',
})
export class AnnouncementService {
  readonly baseURL =
    'http://localhost:8085/DariTn/Announcementcontroller/Announcements';

  constructor(private httpClient: HttpClient) {}

  getAnnouncementList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>(this.baseURL);
  }
  addAnnouncement(announcement: Announcement): Observable<Object> {
    return this.httpClient.post<Announcement[]>(this.baseURL, announcement);
  }

  getAnnouncementById(id: number): Observable<Announcement> {
    return this.httpClient.get<Announcement>(`${this.baseURL}/${id}`);
  }
  updateAnnouncement(
    idan: number,
    announcement: Announcement
  ): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${idan}`, announcement);
  }

  /* idan: number,
    announcement: Announcement
  ): Observable<any> {
    return this.httpClient.put(`${this.baseURL}/${idan}`, announcement);
  }*/

  deleteAnnouncement(id: number): Observable<object> {
    return this.httpClient.delete<Announcement>(`${this.baseURL}/${id}`);
  }

  /********************** */
}
