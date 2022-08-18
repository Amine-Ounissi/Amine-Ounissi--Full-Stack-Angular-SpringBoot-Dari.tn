import { HttpClient, HttpEvent } from '@angular/common/http';
import { HttpEventType, HttpResponse } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Announcement } from '../announcement';
import { AnnouncementService } from '../announcement.service';
import { NgxDropzoneModule } from 'ngx-dropzone';

@Component({
  selector: 'app-crud-announcement',
  templateUrl: './crud-announcement.component.html',
  styleUrls: ['./crud-announcement.component.css'],
})
export class CrudAnnouncementComponent implements OnInit {
  announcements!: Announcement[];
  announcement: Announcement = new Announcement();

  lat: any;
  lng: any;

  files: File[] = [];

  constructor(
    private announcementService: AnnouncementService,
    private router: Router,
    private httpClient: HttpClient /***************/
  ) {}

  //listAn:any;

  ngOnInit(): void {
    //    this.fileInfos = this.annoucementService.getFiles(); /***************** */
    this.getAnnouncements();

    this.get();
  }
  /////////////////

  ////////////////

  updateAnnouncement(idan: number) {
    this.router.navigate(['update-announcement', idan]);
  }

  deleteAnnouncement(idan: number) {
    this.announcementService.deleteAnnouncement(idan).subscribe((data) => {
      console.log(data);
      this.getAnnouncements();
    });
  }

  saveAnnouncement() {
    this.announcementService.addAnnouncement(this.announcement).subscribe(
      (data) => {
        console.log(data);
        this.goToAnnoucementList();
      },
      (error) => console.log(error)
    );
  }
  goToAnnoucementList() {
    this.router.navigate(['/announcements']);
  }

  uploadedImage!: File;
  image: any;
  response: any;

  onImageUpload(event: any) {
    this.uploadedImage = event.target.files[0];
  }

  selectedFile!: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message!: string;
  imageName: any;

  post!: FormGroup;
  // postResponse: any;
  //successResponse!: string;
  //Gets called when the user selects an image

  onSubmit() {
    this.announcementService
      .addAnnouncement(this.announcement)
      .subscribe(() => {
        this.goToAnnoucementList();
      });
  }

  //Gets called when the user clicks on submit to upload the image

  //Gets called when the user clicks on retieve image button to get the image from back end

  announcementDetails(idan: number) {
    this.router.navigate(['announcement-details', idan]);
  }
  private getAnnouncements() {
    this.announcementService.getAnnouncementList().subscribe((data) => {
      this.announcements = data;
    });
  }

  onSelect(event: any) {
    console.log(event);
    this.files.push(...event.addedFiles);

    let image65 = this.baseConvert(this.files[0]);

    //convert base 64
    //this.announcement.img = image65;
  }

  baseConvert(fichier: any) {
    const reader = new FileReader();
    reader.readAsDataURL(fichier);
    reader.onload = () => {
      console.log(reader.result);
      this.announcement.img = reader.result;
    };

    //return reader.result;
  }
  onRemove(event: any) {
    console.log(event);
    this.files.splice(this.files.indexOf(event), 1);
  }
  get() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        if (position) {
          this.announcement.lat = position.coords.latitude;
          this.announcement.lng = position.coords.longitude;

          console.log(position);
        }
      });
    }
  }
}
