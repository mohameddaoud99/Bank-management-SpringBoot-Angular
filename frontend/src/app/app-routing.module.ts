import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListeuserComponent } from './user/listeuser/listeuser.component';
import { LoginuserComponent } from './user/loginuser/loginuser.component'
import { ListecompteComponent } from './compte/listecompte/listecompte.component';

import { AjouteruserComponent } from './user/ajouteruser/ajouteruser.component';
import { UpdateuserComponent } from './user/updateuser/updateuser.component';
import { AjoutercompteComponent } from './compte/ajoutercompte/ajoutercompte.component';
import { UpdatecompteComponent } from './compte/updatecompte/updatecompte.component';


const routes: Routes = [
  {path: '', component: LoginuserComponent},

  /***********************USER************************************ */
  { path: 'listeuser', component: ListeuserComponent },
  { path: 'ajouteruser', component: AjouteruserComponent },
  { path: 'updateuser', component: UpdateuserComponent },
  { path: 'loginuser', component: LoginuserComponent },
  
  /***********************Compte************************************ */
  { path: 'listecompte', component: ListecompteComponent },
  { path: 'ajoutercompte', component: AjoutercompteComponent },
  { path: 'updatecompte', component: UpdatecompteComponent },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
