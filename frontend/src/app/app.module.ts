import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { ListeuserComponent } from './user/listeuser/listeuser.component';
import { LoginuserComponent } from './user/loginuser/loginuser.component'
import { ListecompteComponent } from './compte/listecompte/listecompte.component';
import { FormsModule } from '@angular/forms';
import { AjouteruserComponent } from './user/ajouteruser/ajouteruser.component';
import { UpdateuserComponent } from './user/updateuser/updateuser.component';
import { AjoutercompteComponent } from './compte/ajoutercompte/ajoutercompte.component';
import { UpdatecompteComponent } from './compte/updatecompte/updatecompte.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ServiceuserService } from './services/serviceuser.service';
import { filter_client } from './user/filter_client';
@NgModule({
  declarations: [
    AppComponent,
    ListecompteComponent,
    LoginuserComponent,
    ListeuserComponent,
    AjouteruserComponent,
    UpdateuserComponent,
    AjoutercompteComponent,
    UpdatecompteComponent,
    filter_client
    
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

    
  ],
  providers: [ServiceuserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
