import { Injectable } from "@angular/core";
import { SlidoLiveEvent } from "src/app/component/shared/model/live-event.model";

@Injectable({
 providedIn: 'root'
})
export class EventService {
    constructor() {

    }

    // fetchEventByCode(eventCode: string) {
    //     this.afDb.collection<SlidoLiveEvent>('events', (ref) =>ref.where('code  '))
    //     .valueChanges()
    //     .subscribe((data) => {

    //     })
    // }
}