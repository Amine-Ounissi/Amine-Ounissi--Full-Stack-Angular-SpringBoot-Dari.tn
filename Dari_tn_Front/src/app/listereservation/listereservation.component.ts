import { HttpClient, HttpEvent } from '@angular/common/http';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Reserve } from '../reserve/reserve';
import { ReserveService } from '../services/reserve.service';
import { NgxDropzoneModule } from 'ngx-dropzone';
import { Announcement } from '../announcement';
import { AnnouncementService } from '../announcement.service';
import { LoginService } from '../services/login.service';



  

  

@Component({
  selector: 'app-listereservation',
  templateUrl: './listereservation.component.html',
  styleUrls: ['./listereservation.component.css']
})
export class ListereservationComponent implements OnInit {
  Reserve: Reserve = new Reserve();
  reserves!: Reserve[];
  announcements!: Announcement[];
  announcement: Announcement = new Announcement();
  submitted = false;
  message:string;
  imgAnc: any;
  reservation: any;
  files: File[] = [];
  idU!: any;
  idan!: number;
  
  constructor(
  private reserveService: ReserveService,
  private loginservice: LoginService, 
  private router: Router, private route: ActivatedRoute,
  private httpClient: HttpClient /***************/
  ) { this.message="";this.imgAnc=""}


  ngOnInit(): void {
    this.getReserves();
    this.idan = this.route.snapshot.params['id'];
    this.idU = this.loginservice.getidU(); 
    
  
  }
  
  updateReserve(idV: number) {
    this.router.navigate(['update-reserve', idV]);
  }

 deleteReserve(idV: number) {
    this.reserveService.deleteReserve(idV).subscribe((data) => {
      console.log(data);
      this.getReserves();
    });
  }
  addReservation()
  {
    let rq={}
  }
    newReserve(): void {
      
      this.submitted = false;
      this.Reserve = new Reserve();
    }
   
    saveReserve() {
      this.reserveService.addReserve(this.Reserve,this.idan , this.idU).subscribe(
        (data) => {
          console.log(data);
          this.goToReserveList();
        },
        (error) => console.log(error)
      );
    }

 
  onSubmit() {
    console.log("msg",this.idU)
    this.reserveService
      .addReserve(this.Reserve, this.idan , this.idU)
      .subscribe(() => {
        this.goToReserveList();
      });
  }
  
  goToReserveList() {
    this.router.navigate(['listereservation/',this.idan]);
  }
  reserveDetails(idV: number) {
    this.router.navigate(['reserve-details', idV]);
  }
   
  private getReserves() {
    this.reserveService.getReserveList().subscribe((data) => {
      this.reserves = data;
    });
  }

  onSelect(event: any) {
    console.log(event);
    this.files.push(...event.addedFiles);

    let image65 = this.baseConvert(this.files[0]);

  }

  baseConvert(fichier: any) {
    const reader = new FileReader();
    reader.readAsDataURL(fichier);
    reader.onload = () => {
      console.log(reader.result);
      this.announcement.img = reader.result;
    };
  }
  reloadCurrentPage() {
    window.location.reload();
   }
}


 


  


 
