<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Typeproduit
 *
 * @ORM\Table(name="typeproduit", indexes={@ORM\Index(name="fk14", columns={"id_produit"})})
 * @ORM\Entity
 */
class Typeproduit
{
    /**
     * @var int
     *
     * @ORM\Column(name="idtype", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idtype;

    /**
     * @var int
     *
     * @ORM\Column(name="nomtype", type="integer", nullable=false)
     */
    private $nomtype;

    /**
     * @var \Produit
     *
     * @ORM\ManyToOne(targetEntity="Produit")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_produit", referencedColumnName="id_produit")
     * })
     */
    private $idProduit;

    public function getIdtype(): ?int
    {
        return $this->idtype;
    }

    public function getNomtype(): ?int
    {
        return $this->nomtype;
    }

    public function setNomtype(int $nomtype): self
    {
        $this->nomtype = $nomtype;

        return $this;
    }

    public function getIdProduit()
    {
        return $this->idProduit;
    }

    public function setIdProduit(?Product $idProduit): self
    {
        $this->idProduit = $idProduit;

        return $this;
    }


}
