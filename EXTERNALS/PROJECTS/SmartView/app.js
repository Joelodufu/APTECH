
document.addEventListener("DOMContentLoaded", () => {
  bindActions();
  bindChecklist();
});

/* ---------------------------------------------
   ACTION / MENU HANDLING
----------------------------------------------*/
function bindActions() {
  const actions = document.querySelectorAll(".action");

  actions.forEach((action) => {
    if (action.classList.contains("disabled")) return;

    action.addEventListener("click", () => {
      selectAction(action);
    });
  });
}

function selectAction(actionElement) {
  const label = actionElement.textContent.trim();
  const detailsPanel = document.querySelector(".placeholder");

  // Remove previous highlight
  document.querySelectorAll(".action").forEach((a) => {
    a.style.outline = "none";
  });

  // Highlight selected
  actionElement.style.outline = "2px solid #38bdf8";

  // Update right-side panel
  detailsPanel.innerHTML = `
        <div>
            <h2>${label}</h2>
            <p>This panel represents the detailed Robo-App or Action view.</p>
            <p><em>LabVIEW front-end content would appear here in Phase 2.</em></p>
        </div>
    `;
}

/* ---------------------------------------------
   CHECKLIST HANDLING (VISUAL ONLY)
----------------------------------------------*/
function bindChecklist() {
  const checklistItems = document.querySelectorAll(".checklist-item");

  checklistItems.forEach((item) => {
    item.addEventListener("click", () => {
      toggleChecklist(item);
    });
  });
}

function toggleChecklist(item) {
  const checkIcon = item.querySelector(".check");

  if (checkIcon.textContent === "☐") {
    checkIcon.textContent = "☑️";
  } else {
    checkIcon.textContent = "☐";
  }
}
