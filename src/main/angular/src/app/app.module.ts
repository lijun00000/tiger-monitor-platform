import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgZorroAntdModule, NZ_I18N, zh_CN } from 'ng-zorro-antd';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import { HeaderComponent } from './header/header.component';
import { PlatformManagementComponent } from './platform-management/platform-management.component';
import { CpuGaugeComponent } from './charts/cpu-gauge/cpu-gauge.component';
import { RamGaugeComponent } from './charts/ram-gauge/ram-gauge.component';
import { DiskGaugeComponent } from './charts/disk-gauge/disk-gauge.component';
import { CpuLineComponent } from './charts/cpu-line/cpu-line.component';
import { RamLineComponent } from './charts/ram-line/ram-line.component';
import { FlowLineComponent } from './charts/flow-line/flow-line.component';

registerLocaleData(zh);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PlatformManagementComponent,
    CpuGaugeComponent,
    RamGaugeComponent,
    DiskGaugeComponent,
    CpuLineComponent,
    RamLineComponent,
    FlowLineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgZorroAntdModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [{ provide: NZ_I18N, useValue: zh_CN }],
  bootstrap: [AppComponent]
})
export class AppModule { }
