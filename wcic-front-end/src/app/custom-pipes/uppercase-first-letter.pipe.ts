/**
 * New typescript file
 */
import { Pipe, PipeTransform } from '@angular/core';


@Pipe( { name: 'uppercaseFirst' } )

export class UppercaseFirst implements PipeTransform {
  transform(value: string): string {
    let uppercasedFirst = value !== null ? value.charAt(0).toUpperCase() + value.substring(1, value.length).toLowerCase() : '';

    return uppercasedFirst;
  }
}

