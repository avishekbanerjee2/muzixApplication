import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './../auth-service.service';
import { User } from './../user'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser: User;

  constructor(private authService: AuthenticationService, private router: Router) {
    this.newUser = new User();
  }

  ngOnInit() {
  }

  registerUser() {
    console.log("Register user:", this.newUser.userId, this.newUser.firstName);
    console.log("new user", this.newUser);
    this.authService.registerUser(this.newUser).subscribe(
      (data) => {
        console.log("user data", data);
        this.router.navigate(['/login']);
      }
    );
  }
  resetInput() {
  
  }

}
