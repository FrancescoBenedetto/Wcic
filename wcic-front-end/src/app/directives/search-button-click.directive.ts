/**
 * New typescript file
 */
import { Directive, ElementRef, HostListener, Input } from '@angular/core';
import { Ingredient } from '../ingredient';

@Directive({ selector: '[searchButtonClick]' })

export class SearchButtonClickDirective {

    @Input('selectedIngredients') selectedIngredients: Ingredient[];

    constructor(private el: ElementRef) { }

    @HostListener('click') onClick() {
      this.checkParameters();
  }

  private checkParameters() {
    if (this.selectedIngredients.length === 0) {
      this.el.nativeElement.style.borderColor = 'red';
    }
  }

}
