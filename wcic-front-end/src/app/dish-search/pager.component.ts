import { Component, Input, Output, EventEmitter } from '@angular/core';
import { DishService } from '../services/dish.service'

@Component({
  selector: 'pager',
  templateUrl: './pager.component.html',
  styleUrls: ['./pager.component.css']
})

export class PagerComponent {

  private pageSize: number = 10;
  private currentPage: number;
  private currentPages: number[];
  private pages: number;

  constructor(private dishService: DishService) {
    this.currentPage = 1;
    this.pages = 0;
    this.currentPages = [];
  }

  @Output() pageChanged = new EventEmitter<number>();

  triggerItemsCount(params): void {
    this.dishService.getTotalDishNumber(params.selectedIngredients, params.atLeast, params.dishType)
    .subscribe(dishNumber => this.initParams(dishNumber));
  }

  setCurrentPage(page: number): void {
    if(page !== this.currentPage){
      this.currentPage = page;
      this.pageChanged.emit(this.currentPage);
    }
  }

  private initParams(itemsNumber: number) {
    this.currentPage = 1;
    this.pages = this.calculatePages(itemsNumber);
    this.setPageArray();
  }

  private calculatePages(itemsNumber: number): number  {
    return Math.ceil(itemsNumber/this.pageSize);
  }

  private setPageArray(): void {
    let pageArrayNumber: number = 4;
    if(this.pages < 5) {
      pageArrayNumber = this.pages;
    }
    this.currentPages = new Array(pageArrayNumber).fill(0).map((x,i) => i + 1);
  }

  getCurrentPage(): number {
    return this.currentPage;
  }

  goRight() {
    if(this.currentPage!==this.pages){
      if(this.currentPage === this.currentPages[this.currentPages.length - 1]) {
        this.currentPages = this.currentPages.map(el => el + 1);
      }
      this.setCurrentPage(this.getCurrentPage() + 1);
    }
  }

  goLeft() {
    if(this.currentPage!==1){
      if(this.currentPage === this.currentPages[0]) {
        this.currentPages = this.currentPages.map(el => el - 1);
      }
      this.setCurrentPage(this.getCurrentPage() - 1);
    }
  }








}
