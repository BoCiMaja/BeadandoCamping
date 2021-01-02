import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/FoglalasActionConstants'

export const recordFoglalas = ({foglalasId, cellaSzam, erkezes, tavozas, vezeteknev, keresztnev, telefonszam, tipus, aram }) =>{
    axios.post('/foglalas/record',
        {
            foglalasId : foglalasId,
            cellaSzam : cellaSzam,
            erkezes : erkezes,
            tavozas : tavozas,
            vezeteknev : vezeteknev,
            keresztnev : keresztnev,
            telefonszam : telefonszam,
            tipus : tipus,
            aram : aram
        })
        .then(() => {
            fetchFoglalasok();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchFoglalasok();
        });
}

export const fetchFoglalasok = () =>{

    axios.get('/foglalas/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteFoglalas = ({foglalasId}) =>{
    axios.delete(`/foglalas/${foglalasId}`)
        .then(() => {

            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });

        });
}
