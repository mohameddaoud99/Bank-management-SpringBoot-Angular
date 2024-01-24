import { Component } from '@angular/core';

@Component({
  selector: 'app-ajoutercompte',
  templateUrl: './ajoutercompte.component.html',
  styleUrls: ['./ajoutercompte.component.css']
})
export class AjoutercompteComponent {

  rib!: number;
  solde!: number;
  client!: string;

  onSubmit() {
  
    console.log('Form submitted:', { rib: this.rib, solde: this.solde, client: this.client });
  }
  
}
