function removeSelectedItem() {
    const dropdown = document.getElementById('myDropdown');
    
    if (dropdown.selectedIndex !== -1) {
      dropdown.remove(dropdown.selectedIndex);
    } else {
      alert("Please select an item to remove.");
    }
  }
  