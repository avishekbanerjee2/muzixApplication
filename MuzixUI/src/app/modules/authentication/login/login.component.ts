import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http'

import { User } from './../user';
import { AuthenticationService } from './../auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newUser: User;

  constructor(private authService: AuthenticationService, private router: Router) {
    this.newUser = new User();
  }

  ngOnInit() {
    if (this.authService.getToken() != undefined){
      this.router.navigate(['/muzix/search']);
      
    }
  }
  loginUser() {
    console.log("Registered user", this.newUser.userId, this.newUser.password);
    this.authService.loginUser(this.newUser).subscribe(
      (data) => {
        console.log("logged in");
        if (data['token']) {
          this.authService.setToken(data['token']);
          console.log("token", data['token']);
          location.reload();
          //this.router.navigate(['/muzix/search']);
        }
      }
    );
  }
}
