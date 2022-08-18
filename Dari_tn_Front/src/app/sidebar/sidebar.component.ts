import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  connected: string | null;

  constructor(private router:Router,private loginService:LoginService) {
    this.connected=localStorage.getItem("connected")
    console.log(this.connected)
   }
   auth()
   {

   }
   singOut(){
    this.loginService.loginOut()

    this.router.navigate(['announcements'])

   }
  ngOnInit(): void {
    this.loginService.refreshNeededEtat.subscribe(()=>{
      this.connected=localStorage.getItem("connected")
    })
  }

}
