import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductDetailsComponent } from "./product-details/product-details.component";
import { CheckoutComponent } from "./checkout/checkout.component";
import { ProductListComponent } from "./product-list/product-list.component";
import { FooterComponent } from "./footer/footer.component";
import { SliderComponent } from "./slider/slider.component";
import { ProductListMainPageComponent } from "./product-list-main-page/product-list-main-page.component";

const routes: Routes = [
  {path: '', component: ProductListMainPageComponent},
  {path: 'productList', component: ProductListComponent},
  {path: 'productDetails/:id', component: ProductDetailsComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'received/:orderId', component: CheckoutComponent},
  {path: 'footer', component: FooterComponent},
  {path: 'slider', component: SliderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
