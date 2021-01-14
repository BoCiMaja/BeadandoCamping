import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/BillingActionConstants'

export const recordBill = ({ billId, arrive, leave, firstName, surName, numberOfDays, totalAmount}) =>{
    axios.post('/bill/record',
        {
            billId: billId,
            arrive : arrive,
            leave : leave,
            firstName : firstName,
            surName : surName,
            numberOfDays : numberOfDays,
            totalAmount : totalAmount
        })
        .then(() => {
            fetchBills();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchBills();
        });
}

export const fetchBills = () =>{

    axios.get('/bill/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteBill = ({billId}) =>{
    axios.delete(`/bill/${billId}`)
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
