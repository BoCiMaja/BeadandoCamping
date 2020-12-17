import React from 'react';

function FoglalasListItem({Foglalas_Id, cellaszam, erkezes, tavozas, vezeteknev, keresztnev, telefonszam, tipus, aram }){
    return (
        <span>({Foglalas_Id}, {cellaszam}, {erkezes}, {tavozas}, {vezeteknev}, {keresztnev}, {telefonszam}, {tipus}, {aram})</span>
    );
}

export default FoglalasListItem;
