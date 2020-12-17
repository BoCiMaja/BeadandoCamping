import React from 'react';
import {default as store} from '../store/FoglalasStore'
import FoglalasListItem from "./FoglalasListItem";

class FoglalasList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {foglalasok : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({foglalasok : store._foglalasok});
    }

    render() {
        return(
            <div>
                {this.state.foglalasok.map(({Foglalas_Id, cellaSzam, erkezes, tavozas, vezeteknev, keresztnev, telefonszam, tipus, aram}, index)=>{
                    return(
                        <FoglalasListItem key={index} Foglalas_Id={Foglalas_Id} cellaSzam={cellaSzam} erkezes={erkezes}
                        tavozas={tavozas} vezeteknev={vezeteknev} keresztnev={keresztnev} telefonszam={telefonszam}
                        tipus={tipus} aram={aram}/>
                    );
                })}
            </div>
        );
    }
}

export default FoglalasList;
