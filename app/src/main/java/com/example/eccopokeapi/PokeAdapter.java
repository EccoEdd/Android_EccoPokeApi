package com.example.eccopokeapi;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eccopokeapi.PokeAdapter;

import com.example.eccopokeapi.databinding.ItemPokemonBinding;
import java.util.List;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.ViewHolder> {

    private final List<PokeModel> Pokemons;
    public PokeAdapter(List<PokeModel> pkmn) {
        this.Pokemons = pkmn;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemPokemonBinding binding;
        public ViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonBinding view = ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PokeModel p = Pokemons.get(position);
        holder.binding.PokeNom.setText(p.getmName());
    }

    @Override
    public int getItemCount() {
        return Pokemons.size();
    }


}
