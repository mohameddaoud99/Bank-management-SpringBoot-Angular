import { Pipe, PipeTransform, Injectable } from '@angular/core';

@Pipe({
  name: 'filter_client'
})

@Injectable()
export class filter_client implements PipeTransform {
  transform(items: any[], value1: string){
    if (items && items.length){
      return items.filter(item => {
        if ((value1 && item.prenom.toLowerCase().indexOf(value1.toLowerCase()) === -1) && (value1 && item.nom.toLowerCase().indexOf(value1.toLowerCase()) === -1) ){
          return false;
        }


        return true;
      });
    }
    else{
      return items;
    }
  }
}
