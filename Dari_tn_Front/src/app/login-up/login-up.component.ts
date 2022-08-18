import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login-up',
  templateUrl: './login-up.component.html',
  styleUrls: ['./login-up.component.css']
})
export class LoginUpComponent implements OnInit {
  phone:string; password:string; email:string; lastName:string; name:string;
  message:String


  userRegister()
  {
    let rq:any={email:this.email,password:this.password,name:this.name,lastName:this.lastName,adresse:this.phone}
    this.message="Please wait ..."
    this.loginService.registerFroApi(rq).subscribe(
      (data)=>{this.router.navigate(['announcements']);},(err)=>{this.message="Please verify you're inputs"},()=>{this.message=""})

  }
  constructor(private router:Router,private loginService:LoginService) {
    this.message="";this.phone="";this.password="";this.email="";this.lastName='';this.name=""
  }

  ngOnInit(): void {
  }

}
