import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExampleComponent } from './example/example.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderReceivedComponent } from './order-received/order-received.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { SliderComponent } from './slider/slider.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductListMainPageComponent } from './product-list-main-page/product-list-main-page.component';

@NgModule({
  declarations: [
    AppComponent,
    ExampleComponent,
    ProductDetailsComponent,
    CheckoutComponent,
    ProductListComponent,
    OrderReceivedComponent,
    FooterComponent,
    HeaderComponent,
    SliderComponent,
    ProductListMainPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
