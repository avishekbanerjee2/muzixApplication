import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule, MatIcon, MatInputModule } from '@angular/material';
import { MatCardModule } from '@angular/material/card';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AuthenticationService } from './auth-service.service';
import { AuthenticationRouterModule } from './authentication-router.module';


@NgModule({
  imports: [
    CommonModule,
    FormsModule, 
    MatButtonModule, 
    MatSnackBarModule, 
    MatIconModule, 
    MatFormFieldModule, 
    MatInputModule, 
    MatCardModule,
    AuthenticationRouterModule
  ],
  declarations: [
    RegisterComponent, 
    LoginComponent
  ],
  providers: [AuthenticationService],
  exports:[
    RegisterComponent, 
    LoginComponent
  ]
})
export class AuthenticationModule { }
