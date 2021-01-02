import React from "react";
import * as actions from '../action/FoglalasAction';
import ErrorMessageWell from "./ErrorMessageWell";
class FoglalasRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            foglalasId : null,
            cellaSzam : null,
            erkezes : null,
            tavozas : null,
            vezeteknev : "",
            keresztnev : "",
            telefonszam : "",
            tipus : null,
            aram : true
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
                <label htmlFor={"foglalasId"} >Foglalas ID</label>
                <input type={"number"} id={"foglalasId"} name={"foglalasId"} value={this.state.foglalasId} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"cellaSzam"}>Cellaszám</label>
                <input type={"number"} id={"cellaSzam"} name={"cellaSzam"} value={this.state.cellaSzam} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"erkezes"}>Érkezés</label>
                <input type={"datetime-local"} id={"erkezes"} name={"erkezes"} value={this.state.erkezes} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"tavozas"}>Távozás</label>
                <input type={"datetime-local"} id={"tavozas"} name={"tavozas"} value={this.state.tavozas} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"vezeteknev"}>Vezetéknév</label>
                <input type={"text"} id={"vezeteknev"} name={"vezeteknev"} value={this.state.vezeteknev} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"keresztnev"}>Keresztnév</label>
                <input type={"text"} id={"keresztnev"} name={"keresztnev"} value={this.state.keresztnev} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"telefonszam"}>Telefonszám</label>
                <input type={"text"} id={"telefonszam"} name={"telefonszam"} value={this.state.telefonszam} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"tipus"}>Tipus</label>
                <input type={"number"} id={"tipus"} name={"tipus"} value={this.state.tipus} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"aram"}>Áram</label>
                <input type={"radio"} id={"aram"} name={"aram"} value={this.state.aram} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordFoglalas(this.state)}>Submit</button>
                <button onClick={()=> actions.fetchFoglalasok(this.state)}>List</button>
                <button onClick={()=> actions.deleteFoglalas(this.state)}>Delete</button>
            </div>
        );
    }
}

export default FoglalasRecordingForm
