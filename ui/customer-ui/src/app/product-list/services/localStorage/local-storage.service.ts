import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }

  addSearchParams(json){
    localStorage.setItem('search form', JSON.stringify(json));
  }

  getSearchParams(){
    return localStorage.getItem('search form');
  }

  clearSearchParams(){
    localStorage.clear();
  }
}
