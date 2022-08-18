import { NgModule } from '@angular/core';
import {
  HttpClient,
  HttpClientModule,
  HttpEventType,
} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgxDropzoneModule } from 'ngx-dropzone';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageComponent } from './page/page.component';
import { CrudAnnouncementComponent } from './crud-announcement/crud-announcement.component';
import { UpdateAnnouncementComponent } from './update-announcement/update-announcement.component';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { MapComponent } from './map/map.component';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { LoginComponent } from './login/login.component';
import { LoginUpComponent } from './login-up/login-up.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PaymentComponent } from './payment/payment.component';
import { LoanComponent } from './loan/loan.component';
import { ListereservationComponent } from './listereservation/listereservation.component';
import { UpdateReserveComponent } from './update-reserve/update-reserve.component';
import { ReservedetailsComponent } from './reservedetails/reservedetails.component';
import { ViewreservationComponent } from './viewreservation/viewreservation.component';

@NgModule({
  declarations: [
    AppComponent,
    PageComponent,
    CrudAnnouncementComponent,
    UpdateAnnouncementComponent,
    AnnouncementDetailsComponent,
    MapComponent,
    LoginComponent,
    LoginUpComponent,
    SidebarComponent,
    PaymentComponent,
    LoanComponent,
    ListereservationComponent,
    UpdateReserveComponent,
    ReservedetailsComponent,
    ViewreservationComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxDropzoneModule,
    LeafletModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
