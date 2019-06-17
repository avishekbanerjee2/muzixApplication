import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule, MatButton } from '@angular/material/button';

import { AppComponent } from './app.component';
import { MuzixModule } from './modules/muzix/muzix.module';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AuthguardService } from './authguard.service';

const appRoutes: Routes = [
  {
  path: '',
  redirectTo: '/login',
  pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,   
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MuzixModule,
    AuthenticationModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AuthguardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
