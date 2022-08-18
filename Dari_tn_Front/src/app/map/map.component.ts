import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { AnnouncementService } from '../announcement.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})
export class MapComponent implements AfterViewInit {
  private map: any;
  announcements: any;
  markerService: any;
  mapService: any;
  area: any;

  constructor(private annoucementService: AnnouncementService) {}

  ngAfterViewInit(): void {
    this.annoucementService.getAnnouncementList().subscribe((data: any) => {
      this.announcements = data;
      console.log(this.announcements);
    });

    this.initMap();
    this.markerService.makeCapitalMarkers(this.map);
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: [39.8282, -98.5795],
      zoom: 3,
    });

    const tiles = L.tileLayer(
      'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      {
        maxZoom: 18,
        minZoom: 3,
        attribution:
          '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>',
      }
    );

    tiles.addTo(this.map);
  }
}
