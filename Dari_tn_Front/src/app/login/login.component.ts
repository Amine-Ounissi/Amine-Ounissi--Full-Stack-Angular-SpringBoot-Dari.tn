import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   email:String;
   password:String;
   message:String

  doLogin()
    {

      let rq:any={email:this.email,password:this.password}
      this.message="Please wait ..."
      this.loginService.authenticate(rq).subscribe(
        (data)=>{this.router.navigate(['announcements']);},(err)=>{this.message="Please verify you're email or Password"},()=>{this.message=""})

    }

  constructor(private router:Router,private loginService:LoginService) { this.message="";this.email="";this.password="";}

  ngOnInit(): void {
  }

}
