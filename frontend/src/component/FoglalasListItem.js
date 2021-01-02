import React from 'react';

function FoglalasListItem({foglalasId, cellaSzam, erkezes, tavozas, vezeteknev, keresztnev, telefonszam, tipus}){
    return (
        <span>({foglalasId}, {cellaSzam}, {erkezes}, {tavozas}, {vezeteknev}, {keresztnev}, {telefonszam}, {tipus})</span>
    );
}

export default FoglalasListItem;
