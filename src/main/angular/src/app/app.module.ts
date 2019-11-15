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
import { SystemManagementComponent } from './system-management/system-management.component';
import { SendProcessingComponent } from './charts/processing/send-processing/send-processing.component';
import { ReceiveProcessingComponent } from './charts/processing/receive-processing/receive-processing.component';
import { DomainChartComponent } from './charts/domain-chart/domain-chart.component';
import { DataManagementComponent } from './data-management/data-management.component';
import { RapidTableComponent } from './table/rapid-table/rapid-table.component';
import { ZoneTableComponent } from './table/zone-table/zone-table.component';
import { UploadTableComponent } from './table/upload-table/upload-table.component';
import { ProcessTableComponent } from './table/process-table/process-table.component';
import { LoginComponent } from './login/login.component';

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
    FlowLineComponent,
    SystemManagementComponent,
    SendProcessingComponent,
    ReceiveProcessingComponent,
    DomainChartComponent,
    DataManagementComponent,
    RapidTableComponent,
    ZoneTableComponent,
    UploadTableComponent,
    ProcessTableComponent,
    LoginComponent,
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
