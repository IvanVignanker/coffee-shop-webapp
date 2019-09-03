import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductDetailsComponent } from "./product-details/product-details.component";
import { CheckoutComponent } from "./checkout/checkout.component";
import { ProductListComponent } from "./product-list/product-list.component";
import { FooterComponent } from "./footer/footer.component";

const routes: Routes = [
  {path: '', component: ProductListComponent},
  {path: 'productList', component: ProductListComponent},
  {path: 'productDetails/:id', component: ProductDetailsComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'received/:orderId', component: CheckoutComponent},
  {path: 'footer', component: FooterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
