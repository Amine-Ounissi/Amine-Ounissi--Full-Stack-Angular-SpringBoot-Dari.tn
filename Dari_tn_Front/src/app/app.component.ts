import { Component } from '@angular/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Dari_tn';

  user_id: any = 1;

  constructor() {
    //let token:any;
    // localStorage.setItem('token', this.user_id);
  }

  auth(): void {
    alert('I am connected');
  }
}
