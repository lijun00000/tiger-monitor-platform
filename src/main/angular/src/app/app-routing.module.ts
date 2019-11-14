import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {PlatformManagementComponent} from "./platform-management/platform-management.component";
import {SystemManagementComponent} from "./system-management/system-management.component";


const routes: Routes = [
  {path: "header", component: HeaderComponent},
  {path: "platform-management", component: PlatformManagementComponent},
  {path: "system-management", component:SystemManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
