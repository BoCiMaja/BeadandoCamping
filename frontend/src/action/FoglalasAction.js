import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/FoglalasActionConstants'

export const recordFoglalas = ({Foglalas_Id, cellaSzam, erkezes, tavozas, vezeteknev, keresztnev, telefonszam, tipus, aram }) =>{
    axios.post('/foglalas/record',
        {
            Foglalas_Id : Foglalas_Id,
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

    axios.get('/foglalasok/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteFoglalas = ({Foglalas_Id}) =>{
    axios.delete(`/guest/${Foglalas_Id}`)
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
