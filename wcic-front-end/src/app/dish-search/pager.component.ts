import { Component, Input } from '@angular/core';

@Component({
  selector: 'pager',
  templateUrl: './pager.component.html',
  styleUrls: ['./pager.component.css']
})

export class Pager {

  pageSize: number;

  constructor() {
    this.pageSize = 10;
  }

  calculatePages(itemsNumber: number): number {
    return Math.ceil(itemsNumber/this.pageSize);
  }

  


}
