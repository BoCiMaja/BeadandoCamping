import React from 'react';
import {default as store} from '../store/BillingStore'
import BillingListItem from "./BillingListItem";

class BillingList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {bills : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({bills : store._bills});
    }

    render() {
        return(
            <div>
                {this.state.bills.map(({billId, arrive, leave, firstName, surName, numberOfDays, totalAmount}, index)=>{
                    return(
                        <BillingListItem key={index} billId = {billId} arrive = {arrive} leave = {leave} firstName = {firstName}
                                          surName = {surName} numberOfDays = {numberOfDays} totalAmount = {totalAmount}/>
                    );
                })}
            </div>
        );
    }
}

export default BillingList;
