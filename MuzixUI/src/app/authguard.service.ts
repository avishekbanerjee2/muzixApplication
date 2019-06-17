import { Injectable } from '@angular/core';
import {Router,CanActivate} from '@angular/router';


import { AuthenticationService } from './modules/authentication/auth-service.service';

@Injectable()
export class AuthguardService implements CanActivate
{
    constructor(private router:Router,private authService: AuthenticationService){}

    canActivate(){
        
       /* if(!this.authService.isTokenExpired())
        {
            console.log("in canactivate");
            return true;
        }
        this.router.navigate(['/login']);
        return false; */
        return true;
        
    }
}