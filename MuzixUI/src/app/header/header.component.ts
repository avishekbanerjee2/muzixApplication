import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../modules/authentication/auth-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'mcapp-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthenticationService,private router: Router) { }
  isLogoutVisible:boolean=false;

  ngOnInit() {

    if (this.authService.getToken() != undefined){
      this.isLogoutVisible=true;
      
  }else{
    this.isLogoutVisible=false;
  }
  console.log('TOken'+this.authService.getToken());
  console.log('isLoggedout'+this.isLogoutVisible);
}

  logout(){
    this.isLogoutVisible=false;
    this.authService.deleteToken();
    this.router.navigate(['/login']);
  }

}
