/**
 * New typescript file
 */
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { DishService } from '../services/dish.service';


@Component({
  selector: 'dish-type-selection',
  templateUrl: './dish-type-selection.component.html',
  styleUrls: [ './dish-type-selection.component.css']
})

export class DishTypeSelectionComponent implements OnInit {

  types: any[];
  type2state: Map<string, boolean>;
  hide: boolean;

  constructor(private dishService: DishService) {
    this.types = [];
    this.hide = true;

    //this.type2state = new Map<string, boolean>();
  }

  ngOnInit(): void {
    this.dishService.getDishTypes()
    .subscribe(types => types.forEach(type => this.types.push({name:type, state:true}) ));
    //.subscribe(types => types.forEach( type => this.type2state.set(type, true) ) );
  }

  changeDetailState(): void {
    this.hide ? this.hide = false : this.hide = true;
  }

  changeState(type: string): void {
    let index = this.types.findIndex(el => el.name===type);
    if (index > -1) {
      this.types[index].state ? this.types[index].state = false : this.types[index].state = true;
    }
  }

  getCheckedTypes(): string[] {
    let checkedTypes: string[] = [];
    for(let i:number=0;i<this.types.length;i++){
      if(this.types[i].state){
        checkedTypes.push(this.types[i].name);
      }
    }
    return checkedTypes;
  }

}
