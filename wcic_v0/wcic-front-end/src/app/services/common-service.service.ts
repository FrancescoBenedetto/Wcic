/**
 * New typescript file
 */

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class CommonService {

  baseUrl: string;

  constructor(protected http: Http) {
      this.baseUrl = 'http://localhost:8080';
  }
}
