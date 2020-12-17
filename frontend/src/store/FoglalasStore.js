import {EventEmitter} from 'events'
import dispatcher from "../dispatcher/Dispatcher";
import {refresh} from '../dispatcher/FoglalasActionConstants';

class FoglalasStore extends EventEmitter{

    _foglalasok = [];

    emitChange(){
        this.emit('Change');
    }

    addChangeListener(callback){
        this.addListener('Change',callback);
    }

    removeChangeListener(callback){
        this.removeListener('Change',callback);
    }
}

const store = new FoglalasStore();
export default store;

dispatcher.register(({action,payload})=>{
    if(action !== refresh ) return;
    store._foglalasok = payload;
    store.emitChange();
})
