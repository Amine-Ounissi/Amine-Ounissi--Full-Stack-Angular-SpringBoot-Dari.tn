import { Component, OnInit } from '@angular/core';
import { Announcement } from '../announcement';
import { AnnouncementService } from '../announcement.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

declare const L: any;
@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css'],
})
export class PageComponent implements OnInit {
  announcements!: Announcement[];
  retrieveResonse: any;
  base64Data: any;
  imageName: any;
  retrievedImage: any;

  LikesNB!: number;

  announcement: Announcement = new Announcement();
  constructor(
    private announcementService: AnnouncementService,
    private router: Router,
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
    this.getAnnouncements();
    if (!navigator.geolocation) {
      console.log('location is not supported');
    }
    navigator.geolocation.getCurrentPosition((position) => {
      const coords = position.coords;
      const latLong = [coords.latitude, coords.longitude];
      console.log(
        `lat: ${position.coords.latitude}, lon: ${position.coords.longitude}`
      );
      let mymap = L.map('map').setView(latLong, 13);

      L.tileLayer(
        'https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoicmlhZGhtYXJzIiwiYSI6ImNsMnhzYnhzYjA1bGozanA3MzVubTQycmwifQ.C1jcWgGGgmINm-BcEbNEQA',
        {
          attribution:
            'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
          maxZoom: 18,
          id: 'mapbox/streets-v11',
          tileSize: 512,
          zoomOffset: -1,
          accessToken:
            'pk.eyJ1IjoicmlhZGhtYXJzIiwiYSI6ImNsMnhzYnhzYjA1bGozanA3MzVubTQycmwifQ.C1jcWgGGgmINm-BcEbNEQA',
        }
      ).addTo(mymap);

      let marker = L.marker(latLong).addTo(mymap);
    });
    this.watchPosition();
  }
  watchPosition() {
    let desLat = 0;
    let desLon = 0;
    let id = navigator.geolocation.watchPosition(
      (position) => {
        console.log(
          `lat: ${position.coords.latitude}, lon: ${position.coords.longitude}`
        );
        if (position.coords.latitude === desLat) {
          navigator.geolocation.clearWatch(id);
        }
      },
      (err) => {
        console.log(err);
      },
      {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0,
      }
    );
  }

  private getAnnouncements() {
    this.announcementService.getAnnouncementList().subscribe((data) => {
      this.announcements = data;
    });
  }
  announcementDetails(idan: number) {
    this.router.navigate(['announcement-details', idan]);
  }

  updateAnnouncement(idan: number) {
    this.router.navigate(['update-announcement', idan]);
  }

  deleteAnnouncement(idan: number) {
    this.announcementService.deleteAnnouncement(idan).subscribe((data) => {
      console.log(data);
      this.getAnnouncements();
    });
  }

  public searchEmployees(key: string): void {
    console.log(key);
    const results: Announcement[] = [];
    for (const announcement of this.announcements) {
      if (announcement.object.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(announcement);
      }
    }
    this.announcements = results;
    if (results.length === 0 || !key) {
      this.getAnnouncements();
    }
  }
}
