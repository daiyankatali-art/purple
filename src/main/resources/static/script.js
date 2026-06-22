

document.getElementById("bookingForm").addEventListener("submit", async function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value.toUpperCase();
    const fromLocation = document.getElementById("from").value.toUpperCase();
    const toLocation = document.getElementById("to").value.toUpperCase();
    const travelDate = document.getElementById("date").value;
    const tickets = parseInt(document.getElementById("tickets").value);

    try {
        const response = await fetch("/book", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                name: name.toUpperCase(),
                fromLocation: fromLocation.toUpperCase(),
                toLocation: toLocation,
                travelDate: travelDate,
                tickets: tickets
            })
        });

        // if (!response.ok) {
        //     throw new Error("Booking request failed");
        // }
        if (!response.ok) {
            const errorData = await response.json().catch(() => ({}));
            throw new Error(errorData.message || "Booking request failed");
        }
        const data = await response.json();

        const params = new URLSearchParams({
            ticketId: data.ticketId
        });

        window.location.href = `ticket.html?${params.toString()}`;

    // } catch (err) {
    //     console.error(err);
    //     alert("Something went wrong while booking. Please try again.");
    // }

    } catch (err) {
    console.error(err);
    alert(err.message || "Something went wrong while booking. Please try again.");
}

});


async function refreshAvailability() {
    const fromLocation = document.getElementById("from").value;
    const toLocation = document.getElementById("to").value;
    const travelDate = document.getElementById("date").value;

    const textEl = document.getElementById("availabilityText");
    const fillEl = document.getElementById("availabilityFill");

    if (!fromLocation || fromLocation === "Select a City" ||
        !toLocation || toLocation === "Select a City" || !travelDate) {
        textEl.textContent = "Select route and date to check seats.";
        fillEl.style.width = "0%";
        return;
    }

    if (fromLocation === toLocation) {
        textEl.textContent = "From and To cannot be the same.";
        fillEl.style.width = "0%";
        return;
    }

    try {
        const params = new URLSearchParams({ fromLocation, toLocation, travelDate });
        const res = await fetch(`/availability?${params.toString()}`);
        if (!res.ok) throw new Error("Failed to check availability");
        const data = await res.json();

        if (data.seatsLeft <= 0) {
            textEl.textContent = "Fully booked for this route and date.";
        } else {
            textEl.textContent = `${data.seatsLeft} of ${data.capacity} seats available`;
        }

        const percentFull = ((data.capacity - data.seatsLeft) / data.capacity) * 100;
        fillEl.style.width = percentFull + "%";

    } catch (err) {
        console.error("Availability check failed:", err);
        textEl.textContent = "Could not check seat availability.";
        fillEl.style.width = "0%";
    }
}

["from", "to", "date"].forEach(id => {
    document.getElementById(id).addEventListener("change", refreshAvailability);
});
function formatLocalDate(d) {
    const year = d.getFullYear();
    const month = String(d.getMonth() + 1).padStart(2, "0");
    const day = String(d.getDate()).padStart(2, "0");
    return `${year}-${month}-${day}`;
}

function setDateRange() {
    const dateInput = document.getElementById("date");
    const today = new Date();
    const maxDate = new Date();
    maxDate.setDate(today.getDate() + 7);

    dateInput.min = formatLocalDate(today);
    dateInput.max = formatLocalDate(maxDate);
}

setDateRange();



/* =========================================================
   SEAT MAP CONFIG — keep this in sync with the rest of the bus.
//    ========================================================= */
// const SEAT_CONFIG = {
//     regularRows: 11,
//     rearBenchSeats: 4
// };

// let seatCounter = 1;
// const allSeats = [];

// for (let row = 1; row <= SEAT_CONFIG.regularRows; row++) {
//     for (let i = 0; i < 3; i++) {
//         allSeats.push({ number: seatCounter++, zone: "regular", row });
//     }
// }
// for (let i = 0; i < SEAT_CONFIG.rearBenchSeats; i++) {
//     allSeats.push({ number: seatCounter++, zone: "rear" });
// }

// const selectedSeats = new Set();
// let bookedSeats = []; // already taken for the currently chosen route + date

// function renderSeatMap() {
//     const regularRowsEl = document.getElementById("regularRows");
//     const rearBenchEl = document.getElementById("rearBench");
//     regularRowsEl.innerHTML = "";
//     rearBenchEl.innerHTML = "";

//     for (let row = 1; row <= SEAT_CONFIG.regularRows; row++) {
//         const rowSeats = allSeats.filter(s => s.zone === "regular" && s.row === row);
//         const rowEl = document.createElement("div");
//         rowEl.className = "seat-row";

//         rowEl.appendChild(makeSeatButton(rowSeats[0]));
//         rowEl.appendChild(makeSeatButton(rowSeats[1]));

//         const gap = document.createElement("div");
//         gap.className = "aisle-gap";
//         rowEl.appendChild(gap);

//         rowEl.appendChild(makeSeatButton(rowSeats[2]));
//         regularRowsEl.appendChild(rowEl);
//     }

//     allSeats.filter(s => s.zone === "rear").forEach(s => {
//         rearBenchEl.appendChild(makeSeatButton(s));
//     });
// }

// function makeSeatButton(seat) {
//     const btn = document.createElement("button");
//     btn.type = "button";
//     btn.className = "seat";
//     btn.textContent = seat.number;
//     btn.dataset.seat = seat.number;

//     if (bookedSeats.includes(seat.number)) {
//         btn.classList.add("unavailable");
//         btn.disabled = true;
//     } else {
//         if (selectedSeats.has(seat.number)) {
//             btn.classList.add("selected");
//         }
//         btn.addEventListener("click", () => {
//             if (selectedSeats.has(seat.number)) {
//                 selectedSeats.delete(seat.number);
//                 btn.classList.remove("selected");
//             } else {
//                 selectedSeats.add(seat.number);
//                 btn.classList.add("selected");
//             }
//             updateSeatSummary();
//         });
//     }
//     return btn;
// }

// function updateSeatSummary() {
//     const list = [...selectedSeats].sort((a, b) => a - b);
//     document.getElementById("selectedList").textContent = list.length ? list.join(", ") : "None";
//     document.getElementById("selectedCount").textContent = list.length;
// }

// /* =========================================================
//    FETCH ALREADY-BOOKED SEATS FOR THE CHOSEN ROUTE + DATE
//    ========================================================= */
// async function refreshBookedSeats() {
//     const fromLocation = document.getElementById("from").value;
//     const toLocation = document.getElementById("to").value;
//     const travelDate = document.getElementById("date").value;

//     if (!fromLocation || fromLocation === "Select a City" ||
//         !toLocation || toLocation === "Select a City" || !travelDate) {
//         return;
//     }

//     try {
//         const params = new URLSearchParams({ fromLocation, toLocation, travelDate });
//         const res = await fetch(`/seats?${params.toString()}`);
//         if (!res.ok) throw new Error("Failed to load seat availability");
//         bookedSeats = await res.json();

//         bookedSeats.forEach(n => selectedSeats.delete(n));

//         renderSeatMap();
//         updateSeatSummary();
//     } catch (err) {
//         console.error("Could not load seat availability:", err);
//     }
// }

// ["from", "to", "date"].forEach(id => {
//     document.getElementById(id).addEventListener("change", refreshBookedSeats);
// });

// renderSeatMap();

// /* =========================================================
//    FORM SUBMIT
//    ========================================================= */
// document.getElementById("bookingForm").addEventListener("submit", async function (e) {
//     e.preventDefault();

//     const name = document.getElementById("name").value;
//     const fromLocation = document.getElementById("from").value;
//     const toLocation = document.getElementById("to").value;
//     const travelDate = document.getElementById("date").value;
//     const seatNumbers = [...selectedSeats].sort((a, b) => a - b);

//     if (seatNumbers.length === 0) {
//         alert("Please select at least one seat.");
//         return;
//     }

//     try {
//         const response = await fetch("/book", {
//             method: "POST",
//             headers: { "Content-Type": "application/json" },
//             body: JSON.stringify({ name, fromLocation, toLocation, travelDate, seatNumbers })
//         });

//         if (!response.ok) {
//             const errorData = await response.json().catch(() => ({}));
//             throw new Error(errorData.message || "Booking request failed");
//         }

//         const data = await response.json();
//         const params = new URLSearchParams({ ticketId: data.ticketId });
//         window.location.href = `ticket.html?${params.toString()}`;

//     } catch (err) {
//         console.error(err);
//         alert(err.message || "Something went wrong while booking. Please try again.");
//     }
// });