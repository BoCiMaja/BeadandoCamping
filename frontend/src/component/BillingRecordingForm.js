import React from "react";
import * as actions from '../action/BillingAction';
import ErrorMessageWell from "./ErrorMessageWell";
class BillingRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            billId : null,
            arrive : null,
            leave : null,
            firstName : null,
            surName : null,
            numberOfDays : null,
            totalAmount: null
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render() {
        return(
            <div>
                <ErrorMessageWell/>
                <label htmlFor={"billId"} >Bill ID</label>
                <input type={"number"} id={"billId"} name={"billId"} value={this.state.billId} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"arrive"} >Érkezés</label>
                <input type={"datetime-local"} id={"arrive"} name={"arrive"} value={this.state.arrive} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"leave"}>Távozás</label>
                <input type={"datetime-local"} id={"leave"} name={"leave"} value={this.state.leave} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"firstName"}>Keresztnév</label>
                <input type={"text"} id={"firstName"} name={"firstName"} value={this.state.firstName} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"surName"}>Vezetéknév</label>
                <input type={"text"} id={"surName"} name={"surName"} value={this.state.surName} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"numberOfDays"}>Napok</label>
                <input type={"number"} id={"numberOfDays"} name={"numberOfDays"} value={this.state.numberOfDays} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"totalAmount"}>Összeg</label>
                <input type={"number"} id={"totalAmount"} name={"totalAmount"} value={this.state.totalAmount} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordBill(this.state)}>Submit</button>
                <button onClick={()=> actions.fetchBills(this.state)}>List</button>
                <button onClick={()=> actions.deleteBill(this.state)}>Delete</button>
            </div>
        );
    }
}

export default BillingRecordingForm
